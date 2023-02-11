package com.github.jumpbyte.practice.netty.chapter10;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * http 文件服务器
 *
 * @author yuanjinan
 */
public class HttpFileServer {

    private static final String DEFAULT_URL = "/src/main/java/com";


    public void run(int port, String url) throws Exception {
        //1:创建EventLoopGroup
        //boss 主线程 值负责连接的建立
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        //工作线程 专门负责I/O读写处理
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            //2:创建ServerBootstrap
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workGroup)
                    //3:指定所使用的NIO传输channel
                    .channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    //5：添加一个EchoServerHandler到channel的ChannelPipeline
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast("http-decoder",
                                    new HttpRequestDecoder()); // 请求消息解码器
                            ch.pipeline().addLast("http-aggregator",
                                    new HttpObjectAggregator(65536));// 目的是将多个消息转换为单一的request或者response对象
                            ch.pipeline().addLast("http-encoder",
                                    new HttpResponseEncoder());//响应编码器
                            ch.pipeline().addLast("http-chunked",
                                    new ChunkedWriteHandler());//目的是支持异步大文件传输（）
                            ch.pipeline().addLast("fileServerHandler",
                                    new HttpFileServerHandler(url));// 业务逻辑
                        }
                    });
            //6:异步绑定服务器端口，调用sync方法阻塞等待直到绑定完成
            ChannelFuture f = serverBootstrap.bind("localhost", port).sync();
            System.out.println("HTTP 文件目录服务器已启动，网址: http://localhost:" + port + url);
            //7:获取Channel的closeFuture，并且阻塞当前线程直到完成
            f.channel().closeFuture().sync();
        } finally {
            //8:关闭EventLoopGroup,释放所有资源
            bossGroup.shutdownGracefully().sync();
            workGroup.shutdownGracefully().sync();
        }
    }

    public static void main(String[] args) throws Exception {
        new HttpFileServer().run(8080, DEFAULT_URL);
    }
}

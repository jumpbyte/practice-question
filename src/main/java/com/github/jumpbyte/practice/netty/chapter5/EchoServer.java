package com.github.jumpbyte.practice.netty.chapter5;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.net.InetSocketAddress;

/**
 * 分隔符解码编码实例
 *
 * @author yuanjinan
 */
public class EchoServer {

    private final int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public void run() throws Exception {
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
                    //4:绑定端口
                    .localAddress(new InetSocketAddress(port))
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    //5：添加一个EchoServerHandler到channel的ChannelPipeline
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ByteBuf delimiter = Unpooled.copiedBuffer("$_".getBytes());
                            ch.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, delimiter));
                            ch.pipeline().addLast(new StringDecoder());
                            ch.pipeline().addLast(new EchoServerHandler());
                        }
                    });
            //6:异步绑定服务器端口，调用sync方法阻塞等待直到绑定完成
            ChannelFuture f = serverBootstrap.bind().sync();
            System.out.println(com.github.jumpbyte.practice.netty.server.EchoServer.class.getName() +
                    " started and listening for connections on " + f.channel().localAddress());
            //7:获取Channel的closeFuture，并且阻塞当前线程直到完成
            f.channel().closeFuture().sync();
        } finally {
            //8:关闭EventLoopGroup,释放所有资源
            bossGroup.shutdownGracefully().sync();
            workGroup.shutdownGracefully().sync();
        }
    }

    public static void main(String[] args) throws Exception {
        new EchoServer(9091).run();
    }
}

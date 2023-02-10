package com.github.jumpbyte.practice.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * @author yuanjinan
 */
public class EchoServer {

    public static void main(String[] args) throws Exception {
        EchoServer echoServer = new EchoServer();
        echoServer.run();
    }

    public void run() throws Exception {
        final EchoServerHandler serverHandler = new EchoServerHandler();
        //1:创建EventLoopGroup
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            //2:创建ServerBootstrap
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(group)
                    //3:指定所使用的NIO传输channel
                    .channel(NioServerSocketChannel.class)
                    //4:绑定端口
                    .localAddress(new InetSocketAddress(9090))
                    //5：添加一个EchoServerHandler到channel的ChannelPipeline
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(serverHandler);
                        }
                    });
            //6:异步绑定服务器端口，调用sync方法阻塞等待直到绑定完成
            ChannelFuture f = serverBootstrap.bind().sync();
            System.out.println(EchoServer.class.getName() +
                    " started and listening for connections on " + f.channel().localAddress());
            //7:获取Channel的closeFuture，并且阻塞当前线程直到完成
            f.channel().closeFuture().sync();
        } finally {
            //8:关闭EventLoopGroup,释放所有资源
            group.shutdownGracefully().sync();
        }
    }
}

package com.github.jumpbyte.practice.netty.chapter5;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author yuanjinan
 */
public class EchoClientHandler extends ChannelInboundHandlerAdapter {


    private int counter = 0;
    private String msg = "hi yuanjinan,welcome to Netty World. $_";


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("client receive " + (++counter) + " times server msg:" + msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.channel().flush();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i = 0; i < 10; i++) {
            ctx.writeAndFlush(Unpooled.copiedBuffer(msg.getBytes()));
        }
    }
}

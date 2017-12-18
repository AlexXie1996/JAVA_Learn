# socket+聊天机器人

- 刚接触socket写的一个小程序，扔了一个聊天机器人的ａｐｉ进去

## 环境

- java + 图灵机器人的api->http://www.tuling123.com/

## 实现

- 参考计算机网络－自顶向下方法第二章，实现了使用TCP和UDP的两种Socket
- 一共有６个java文件，包括：
  + TCPClient 用TCP的Socket客户端，聊天机器人的客户端
  + TCPClientTest 用TCP的Socket客户端,用于测试服务器端的连线状态
  + TCPServerLinstener 用TCP的Socket服务器端，聊天机器人服务器端，监听进程
  + TCPServerExc 用TCP的Socket服务器端，聊天机器人服务器端，实际ＴＣＰ连接线程
  + UDPClient 用UDP的Socket客户端
  + UDPServer 用UDP的Socket服务器端，只实现了将客户端传来的英文小写字符转成大写字符回传
  
## 使用

- 打开客户端和服务器端的java修改参数，包括：
  + 客户端和服务器端的进程端口号port
  + 客户端中修改服务器端主机名
  + TCP服务器端的图灵机器人api的key

- 先编译解释服务器端java文件，再编译解释客户端java文件

## 说明

- 使用TCP的Socket接入了聊天机器人，用UTF_8编码，输入中文即可，UDP的Socket只实现了英文大小写转换，输入中文会出现乱码
- 实现了监听进程，可以同时开多个客户端进程

## 问题

 - Linux上运行没有问题，在win10上测试的时候会多传一个未知字符，导致socket解码有问题出现乱码，以后再修复

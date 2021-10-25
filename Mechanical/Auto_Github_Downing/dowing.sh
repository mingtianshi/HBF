#!/bin/bash

function my_cmd(){
    your="https://github.91chifun.workers.dev//"
    your_name="`cat ./git.link`.git"

    t=$RANDOM
    t=$[t%15]
    sleep $t
    echo "sleep $t s"
}

tmp_fifofile="/tmp/$$.fifo"
mkfifo $tmp_fifofile      # 新建一个fifo类型的文件
exec 6<>$tmp_fifofile     # 将fd6指向fifo类型
rm $tmp_fifofile    #删也可以

thread_num=5  # 最大可同时执行线程数量
job_num=100   # 任务总数

#根据线程总数量设置令牌个数
for ((i=0;i<${thread_num};i++));do
    cat ./git.link | while read line
    do
    git clone `echo ${your}${line}`
    echo "${line}"
    done
done >&6

for ((i=0;i<${job_num};i++));do # 任务数量
    # 一个read -u6命令执行一次，就从fd6中减去一个回车符，然后向下执行，
    # fd6中没有回车符的时候，就停在这了，从而实现了线程数量控制
    read -u6

    #可以把具体的需要执行的命令封装成一个函数
    {
        my_cmd
    } &

    echo >&6 # 当进程结束以后，再向fd6中加上一个回车符，即补上了read -u6减去的那个
done

wait
exec 6>&- # 关闭fd6
echo "over"

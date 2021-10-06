## 注意
lim.txt
存放URL地址文件的地方

运行代码

```bash
bash ./dowing.sh
```

dowing.sh

```bash
#! bash
your="https://github.91chifun.workers.dev//"
your_name="`cat lim.txt`.git"
cat lim.txt | while read line
do
	git clone `echo ${your}${line}`
    echo "${line}"
done
while read line
do
    echo "${your}${line}"
done < lim.txt
```

主要功能是在当前目录下单线程下载库



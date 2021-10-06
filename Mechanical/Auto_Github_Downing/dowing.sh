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

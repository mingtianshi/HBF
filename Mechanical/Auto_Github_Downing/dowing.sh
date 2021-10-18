#! bash
_91chifun="https://github.91chifun.workers.dev//"
your_name="`cat lim.txt`.git"
cat lim.txt | while read line
do
    git clone `echo ${_91chifun}${line}`
    echo "${line}"
done

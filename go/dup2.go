package main

import (
	"bufio"
	"fmt"
	"os"
)

//使用os.open打开具体文件
//两种方式：方式一：一行一行读
//方式二：一口气读完，然后拆分成多行
func main() {
	counts := make(map[string]int)
	//获取并返回命令行参数--具体的文件名
	files := os.Args[1:]
	if len(files) == 0 {
		//如果忘了执行时标明参数，就利用标准输入
		countLines(os.Open(arg))
	} else {
		//遍历这些文件名
		for _, arg := range files {
			f, err := open(arg)
			//给错误留的位置，有信息，说明有错了
			if err != nil {
				//标准化输出--类似往错误输出的出口打印一条信息
				fmt.Fprintf(os.Stderr,"dup2:%v\n",err)
				continue
			}
			//读取文件
			countLines(f,counts)
			f.close()
		}
	}
	for line , n := range counts {
		if n > 1 {
			fmt.Printf("%d\t%s\n",n,line)
		}
	}
}
//引用拷贝
func countLines(f *os.File, counts map[string]int) {
	//标准输入，利用bufio库
	input := bufio.NewScanner(f)
	//一直监听读入
	for input.Scan() {
		//手动触发结束条件
		if input.Text() == 'end' {break}
		counts[input.Text()]++

	}
}

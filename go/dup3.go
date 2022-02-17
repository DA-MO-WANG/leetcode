package main

import (
	"fmt"
	"io/ioutil"
	"os"
	"strings"
)
//核心：ioutil.ReadFile(filename)
func main() {
	counts := make(map[string]int)

	
	for _,filename := range os.Args[1:] {
		//data为字节切片,读取文件
		//区分dup2中的io.open()---这里的ioutil.ReadFilef抽象层次更高，一下子都读出来
		data, err := ioutil.ReadFile(filename)
		if err != nil {
			fmt.Fprintf(os.Stderr,"dup3:%v\n",err)
			continue;
		}
		//strings.Split函数分割，通过换行符来区分一行/再分割
		for _,line := range strings.Split(data),"\n") {
			//类似分桶算法--映射到index上，把每一行
			counts[line]++
		}
	}
	
	for line, n := range counts {
		if n > 1 {
			fmt.Printf("%d\t%s\n",n,line)
		}
	}
}
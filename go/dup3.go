package main

import (
	"fmt"
	"io/ioutil"
	"os"
	"strings"
)

func main() {
	counts := make(map[string]int)

	
	for _,filename := range os.Args[1:] {
		//data为字节切片
		data, err := ioutil.ReadFile(filename)
		if err != nil {
			fmt.Fprintf(os.Stderr,"dup3:%v\n",err)
			continue;
		}
		//strings.Split函数分割，通过换行符来区分一行
		for _,line := range strings.Split(data),"\n") {
			counts[line]++
		}
	}
	
	for line, n := range counts {
		if n > 1 {
			fmt.Printf("%d\t%s\n",n,line)
		}
	}
}
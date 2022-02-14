package main
import "fmt"
import "os"

func main() {
    var s string
    //关键就在os.Args---对它的认知就是数组
    //   
    for i := 1; i < len(os.Args); i++ {
	s +=  os.Args[i]
    }
    fmt.Println(s)
}

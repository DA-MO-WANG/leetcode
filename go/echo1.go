package main
import "fmt"
import "os"

func main() {
    var s, sep string   
    for i := 1; i < len(os.Args); i++ {
	s += sep + os.Args[i]
	sep = " "
    }
    fmt.println(s)
}

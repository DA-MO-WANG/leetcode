package main
import "fmt"
import "os"

func main() {
   s, sep := "", ""
   for index,arg := range os.Args[1:] {
      s += sep + arg + "-" + index
      sep = " "
   }
   fmt.Println(s)
}

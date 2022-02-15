package main
import "fmt"
import "os"

func main() {
   s, sep := "", ""
   for index,arg := range os.Args[1:] {
      y := fmt.Sprintf("%d",index)
      s += sep + arg + "-" + y
      sep = " "
   }
   fmt.Println(s)
}

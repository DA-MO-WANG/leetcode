package main
import "fmt"
import "os"
import "strconv"

func main() {
   s, sep := "", ""
   for index,arg := range os.Args[1:] {
      
      s += sep + arg + "-" + strconv.Itoa(index)
      sep = " "
   }
   fmt.Println(s)
}

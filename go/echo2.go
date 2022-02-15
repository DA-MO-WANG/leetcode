package main
import "fmt"
import "os"

func main() {
   s, sep := "", ""
   for index,arg := range os.Args[1:] {
      
      s += sep + arg + "-" + strconv.Itoa(x)
      sep = " "
   }
   fmt.Println(s)
}

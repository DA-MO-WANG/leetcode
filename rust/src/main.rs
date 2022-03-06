fn main() {
    println!("the nth number.");
    let n = 10;
    let m = if n == 1 {
        2
    }else if n == 2 {
        3
    }else {
        8
    };
    println!("{}",m)
}
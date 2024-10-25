import static com.amoalla.euler.utils.Maths.fibonacciBig;

/// # 1000-digit Fibonacci Number
/// <p>The Fibonacci sequence is defined by the recurrence relation:</p>
/// <blockquote>F_n = F_{n - 1} + F_{n - 2}, where F_1 = 1 and F_2 = 1.</blockquote>
/// <p>Hence the first 12 terms will be:</p>
/// F_1 = 1<br>
/// F_2 = 1<br>
/// F_3 = 2<br>
/// F_4 = 3<br>
/// F_5 = 5<br>
/// F_6 = 8<br>
/// F_7 = 13<br>
/// F_8 = 21<br>
/// F_9 = 34<br>
/// F_{10} = 55<br>
/// F_{11} = 89<br>
/// F_{12} = 144<br>
/// <p>The 12th term, F_{12}, is the first term to contain three digits.</p>
/// <p>What is the index of the first term in the Fibonacci sequence to contain 1000 digits?</p>
void main() {
    int i = 2;
    for (BigInteger fib : fibonacciBig()) {
        i++;
        if (fib.toString().length() == 1000) {
            println(i);
            break;
        }
    }
}
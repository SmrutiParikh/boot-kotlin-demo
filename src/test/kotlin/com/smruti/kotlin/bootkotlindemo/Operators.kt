package com.smruti.kotlin.bootkotlindemo

class Operators{
    fun runTest(){
        println( "Arithmetic Operators : ")// +, -, *, /, %
        val num1 = 64
        val num2 = 32
        var answer: Int
        answer = num1 + num2
        println("sum = $answer")  // sum = 96
        answer = num1 - num2
        println("diff = $answer")     // diff = 32
        answer = num1 * num2
        println("mult = $answer")  // mult = 2048
        answer = num1 / num2
        println("div = $answer")  // div = 2
        answer = num1 % num2
        println("mod = $answer")  // mod = 0

        val fname = "Laxman"
        val lname = "das"
        val full_name = fname + " " +lname
        val full_name2 = "$fname $lname"
        println ( arrayListOf( full_name, full_name2 ) )          // Laxman das

        println( "\nAssignment Operators : ")// +=, -=, *=, /=, %=
        var number1 = 22
        var number2 = 20
        number1 += 10
        number2 %= 3
        println ("Result1 = $number1")    // Result1 = 32
        println ("Result2 = $number2")    // Result2 = 2

        println( "\nUnary Operator :")//  +, -, !, ++, --
        val a = 5
        var b = 10
        var c = 15
        val negation = -a
        val increment = ++b
        val dec = c--
        println ("Negation = $negation")      // Negation = -5
        println ("Increment = $increment")    // Increment = 11
        println ("Decrement = $dec")            // Decrement = 15
        println ("Variable = $c")            // Decrement = 14

        println( "\nComparision Operators : ")// >, < , >=, <=
        val numm1 = 20
        val numm2 = 30
        if (numm1 > numm2)
        {
            println ("greater number is $numm1")
        }
        else
        {
            println ("greater number is $numm2")     //greater number is 30
        }

        println( "\nEquality and Non-equality Operators : ") // !=, ==,
        val x = 3
        val y = 6
        println ( x==y )     //false
        println ( x!=y )     // true


        println( "\nLogical Operators : ")// && , || , !

        val m = 20
        val n = 4
        val o = -8
        val ans : Boolean
        ans = (m>n) || (m<o)
        println ("answer is $ans")  // answer is true


        println( "\nIn Operator :")// in, not in
        val array = intArrayOf(10, 20, 30 ,40)
        if (20 in array)
        {
            println ("yes 20 is present in array")       // yes 20 is present in array
        }
        else
        {
            println ("no 20 is not present in array")
        }

        println( "\nRange Operator:") // ..

        for (i in 1..10)
        {
            println ("value of i is $i")     // value of i is 1
        }                                         //value of i is 2 till value of i is 10

        println( "\nIndexed Access Operator:") //a[i], a[i] = b
        val array2 = intArrayOf(10, 20, 30, 40, 50)
        val value = array2[1]
        println("value at index 1 is $value")         //value at index 1 is 20
        array2[1] = 90
        println ("recent value at index 1 is " + array2[1])  //recent value at index 1 is 90

        println( "\nBitwise Operators: ") //shl, shr, ushr, and, or, xor, inv
        val l = 12
        val k = 10
        val result1 : Int
        val result2 : Int
        result1 = l and k
        result2 = l or k
        println ("final result of and operation is $result1")  // final result of and operation is 8
        println ("final result of or operation is $result2")  // final result of or operation is 14
    }
}
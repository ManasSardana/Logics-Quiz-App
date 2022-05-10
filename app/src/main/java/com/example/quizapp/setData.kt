package com.example.quizapp

object setData {

    const val name:String="name"
    const val score:String="score"

   fun getQuestion():ArrayList<QuestionData>{
       var que:ArrayList<QuestionData> = arrayListOf()

       var question1 = QuestionData(
           1,
           "Look at the series: 12,11,13,12,14,13,... ?",
           "10",
           "16",
           "13",
           "15",
           4
       )
       var question2 = QuestionData(
           2,
           "Which word does NOT belong with the others?",
           "Index",
           "Glossary",
           "Book",
           "Chapter",
           3
       )
       var question3 = QuestionData(
           3,
           "CUP:LIP::BIRD:?",

           "GRASS",
           "BREAK",
           "FOREST",
           "BUSH",
           2
       )
       var question4 = QuestionData(
           4,
           "If HOT is coded as GNS, How is COLD coded?",
           "BNKC",
           "DPME",
           "EQNF",
           "FROG",
           1
       )

       var question5 = QuestionData(
           5,
           "Which word is the odd man out?",
           "Trival",
           "Unimportant",
           "Important",
           "Insignificant",
           3
       )

       var question6 = QuestionData(
           6,
           "80,10,70,15,60,... What should come next ?",
           "20",
           "25",
           "30",
           "50",
           1
       )

       var question7 = QuestionData(
           7,
           "SAFE:SECURE::PROTECT:?",
           "LOCK",
           "SURE",
           "GUARD",
           "CONSERVE",
           3
       )

       var question8 = QuestionData(
           8,
           "Statement:Medicine 'P' is a drug which is causing ripples in the medical field. Assumption1: No other drug is causing ripples in the medical field. 2. Medicine 'p' is a great drug.",
           "Either 1 or 2 is implicit.",
           "Neither 1 or 2 is implicit.",
           "Only 1 is implicit",
           "Only 2 is implicit",
           2
       )

       var question9 = QuestionData(
           9,
           "In a certain code, TREE is written as UQFD. How is LEAF written in that code?",
           "MFBG",
           "KDZE",
           "MDBE",
           "MBZE",
           3
       )

       var question10 = QuestionData(
           10,
           "Pointing to a Photograph, A man said,'I have no brother, and that man's father is my fathers son'. Whose Photograph was it?",
           "His Own",
           "His Son",
           "His Father",
           "His Nephew",
           2
       )

       var question11 = QuestionData(
           11,
           "\t\n" +
                   "Here are some words translated from an artificial language.\n" +
                   "1) gorblflur means fan belt\n" +
                   "2) pixngorbl means ceiling fan\n" +
                   "3) arthtusl means tile roof\n" +
                   "4) Which word could mean \"ceiling tile\"?",
           "gorbltusl",
           "flurgorbl",
           "pixnarth",
           "arthflur",
           3
       )

       var question12 = QuestionData(
           12,
           "Odometer is to mileage as compass is to ?",
           "speed",
           "hiking",
           "needle",
           "direction",
           4
       )

       var question13 = QuestionData(
           13,
           "Cup is to coffee as bowl is to",
           "soup",
           "dish",
           "spoon",
           "food",
           1
       )

       var question14 = QuestionData(
           14,
           "B2CD, _____, BCD4, B5CD, BC6D",
           "B2C2D",
           "BC3D",
           "B2C3D",
           "BCD7",
           2
       )

       var question15 = QuestionData(
           15,
           "Look at this series: 53, 53, 40, 40, 27, 27, ... What number should come next?",
           "12",
           "27",
           "53",
           "14",
           4
       )

       var question16 = QuestionData(
           16,
           "What is the average of first five multiples of 12?",
           "38",
           "42",
           "36",
           "40",
           3
       )

       var question17 = QuestionData(
           17,
           "What is the difference in the place value of 5 in the numeral 754853",
           "49990",
           "49950",
           "48950",
           "49000",
           2
       )

       var question18 = QuestionData(
           18,
           "If January 1, 1996, was Monday, what day of the week was January 1, 1997?",
           "Wednesday",
           "Tuesday",
           "Thursday",
           "Friday",
           1
       )

       var question19 = QuestionData(
           19,
           "How many times the hands of a clock coincide in a day?",
           "24",
           "22",
           "25",
           "20",
           2
       )

       var question20 = QuestionData(
           20,
           "40 % of 280 =?",
           "120",
           "115",
           "116",
           "112",
           4
       )

       var question21 = QuestionData(
           21,
           "The value of 51/4 x (125)0.25 is",
           "5√5",
           "√5",
           "5",
           "25",
           3
       )

       var question22 = QuestionData(
           22,
           "A: B: C is in the ratio of 3: 2: 5. How much money will C get out of Rs 1260?",
           "None Of These",
           "125",
           "505",
           "252",
           1
       )

       var question23 = QuestionData(
           23,
           "In a certain code language, ‘ANIMALS’ is written as ‘SLAMINA’. How is ‘ONLINE’ written in that code?",
           "OLINEN",
           "ENILNO",
           "LNOINE",
           "NNLOIE",
           2
       )

       var question24 = QuestionData(
           24,
           "Two numbers are respectively 20% and 50% more than a third number. The ratio of the two numbers is:",
           "2:5",
           "5:4",
           "4:5",
           "3:5",
           3
       )

       var question25 = QuestionData(
           25,
           "Find the odd man out.\n" +
                   "\n" +
                   "2, 5, 10, 17, 26, 37, 50, 64",
           "26",
           "50",
           "37",
           "64",
           4
       )

       var question26 = QuestionData(
           26,
           "A person crosses a 600 m long street in 5 minutes. What is his speed in km per hour?",
           "7.2",
           "8.4",
           "9.6",
           "5.8",
           1
       )

       var question27 = QuestionData(
           27,
           "An accurate clock shows 8 o'clock in the morning. Through how may degrees will the hour hand rotate when the clock shows 2 o'clock in the afternoon?",
           "260'",
           "180'",
           "240'",
           "120'",
           2
       )

       var question28 = QuestionData(
           28,
           "Find the odd man out :- 8, 27, 64, 100, 125, 216, 343",
           "27",
           "216",
           "100",
           "64",
           3
       )

       var question29 = QuestionData(
           29,
           "What was the day of the week on 28th May, 2006?",
           "Saturday",
           "Thursday",
           "Monday",
           "Sunday",
           4
       )

       var question30 = QuestionData(
           30,
           "\t\n" +
                   "(112 x 54) = ?",
           "70000",
           "68000",
           "69000",
           "69500",
           1
       )

       var question31 = QuestionData(
           31,
           "\t\n" +
                   "Which of the following is a prime number ? : ",
           "33",
           "81",
           "97",
           "63",
           3
       )

       var question32 = QuestionData(
           32,
           "\t\n" +
                   "A father said to his son, \"I was as old as you are at the present at the time of your birth\". If the father's age is 38 years now, the son's age five years back was:",
           "19 Years",
           "14 Years",
           "38 Years",
           "33 Years",
           2
       )

       var question33 = QuestionData(
           33,
           "\t\n" +
                   "A is two years older than B who is twice as old as C. If the total of the ages of A, B and C be 27, then how old is B?",
           "7",
           "8",
           "9",
           "10",
           4
       )

       var question34 = QuestionData(
           34,
           "(17)3.5 x (17)? = 178",
           "4.5",
           "4.25",
           "3.9",
           "5",
           1
       )

       var question35 = QuestionData(
           35,
           "\t\n" +
                   "If 5a = 3125, then the value of 5(a - 3) is:",
           "625",
           "125",
           "25",
           "5",
           3
       )


       que.add(question1)
       que.add(question2)
       que.add(question3)
       que.add(question4)
       que.add(question5)
       que.add(question6)
       que.add(question7)
       que.add(question8)
       que.add(question9)
       que.add(question10)
       que.add(question11)
       que.add(question12)
       que.add(question13)
       que.add(question14)
       que.add(question15)
       que.add(question16)
       que.add(question17)
       que.add(question18)
       que.add(question19)
       que.add(question20)
       que.add(question21)
       que.add(question22)
       que.add(question23)
       que.add(question24)
       que.add(question25)
       que.add(question26)
       que.add(question27)
       que.add(question28)
       que.add(question29)
       que.add(question30)
       que.add(question31)
       que.add(question32)
       que.add(question33)
       que.add(question34)
       que.add(question35)
       return que
   }

}
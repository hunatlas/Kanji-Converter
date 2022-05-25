# Kanji-Converter
A multithreading program written in Java that converts arabic numbers to kanjis

The program was a practice task for the exam of my concurrent programming exam.
The goal was to realize a multithreading program that generates some random numbers, converts them to kanjis, creates a string from the two values and puts them into a list.
The three tasks that followed each other in ascending complexity were completed in different Java classes, the name of each mirrors the number of the task.
During the exercise different elements of multithreading programming were applied as creating, starting and handling multiple threads, synchronizing access to common resources, working with thread safe datastructures, solving the porducer-consumer problem.

The KanjiLib and Tester classes were already written and the skeletons of the Task classes were also provided.

On Windows systems, at compiling encoding must be ensured:
`javac -encoding UTF-8 Tester.java`

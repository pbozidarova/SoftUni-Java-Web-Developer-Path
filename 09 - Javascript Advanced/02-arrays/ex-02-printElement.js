// 2.	Print Every N-th Element from an Array 
// The input comes as an array of strings. The last element is N - the step.
// The output is every element on the N-th step starting from the first one. 
// If the step is "3", you need to print the 1-st, the 4-th, the 7-th … and so on, 
// until you reach the end of the array. The elements must be printed each on a new line.

function solve(input){
    let step = Number(input.pop());

    input.forEach((num, index) => {
        if(index % step == 0){
            console.log(num);
        }
    });
}

solve(['5', 
'20', 
'31', 
'4', 
'20', 
'2']
);

solve(['dsa',
'asd', 
'test', 
'tset', 
'2']
);

solve(['1', 
'2',
'3', 
'4', 
'5', 
'6']
);

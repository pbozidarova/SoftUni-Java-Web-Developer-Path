// 6.	Sort an Array by 2 Criteria
// Write a function that orders a given array of strings, by length in ascending order 
// as primary criteria, and by alphabetical value in ascending order as second criteria. 
// The comparison should be case-insensitive.
// The input comes as an array of strings.
// The output is the ordered array of strings.

function solve(input){

    input.sort((current, next) => {
        if(current.length > next.length){
            return 1;
        } else if(current.length === next.length){
            return current.localeCompare(next);
        } else {
            return -1;
        }
    }).forEach(element => {
            console.log(element);
    });
}

solve(['alpha', 'beta', 'gamma']);

solve(['Isacc', 'Theodor', 'Jack', 'Harrison', 'George']);

solve(['test', 'Deny', 'omen', 'Default']);
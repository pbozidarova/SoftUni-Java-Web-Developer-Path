// 2.	Sum by Town
// You’re tasked with calculating the total sum of income for a number of Towns. 
// You will receive an array of strings representing towns and their incomes, every even index will be a town and every 
// odd index will be an income belonging to that town. Create an object that will hold all the towns as keys and their total 
// income (the sum of their incomes) as values to those keys and print it as a JSON. 
// Input
// The input comes as an array of strings - each even index is the name of a town and each odd index is an income belonging to that town.
// Output
// The output should be printed on the console - JSON representation of the object containing all towns and their total incomes.

function solve(input){
    let resultObj = {};
    for(let i = 0; i < input.length; i+=2){
        let town = input[i];
        let income = Number(input[i+1]);
        if(!resultObj[town]) {
            resultObj[town] = 0;
        }
        resultObj[town] += income;
    }
    console.log(JSON.stringify(resultObj));
}
solve(['Sofia','20','Varna','3','Sofia','5','Varna','4']);
solve(['Sofia','20','Varna','3','sofia','5','varna','4']);
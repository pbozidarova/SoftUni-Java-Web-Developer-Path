// 8.	Tickets
// Write a program that manages a database of tickets. A ticket has a destination, a price and a status. 
// Your program will receive two arguments - the first is an array of strings for ticket descriptions and the second is a string, 
// representing a sorting criterion. The ticket descriptions have the following format:
// <destinationName>|<price>|<status>
// Store each ticket and at the end of execution return a sorted summary of all tickets, sorted by either destination, 
// price or status, depending on the second parameter that your program received. Always sort in ascending order 
// (default behavior for alphabetical sort). If two tickets compare the same, use order of appearance. 

    function solve(input, criteria){

        let output = [];
        let ticketObject = {};

        input.forEach(ticket => {
            let [destination, price, status] = ticket.split('|');
            price = Number(price);
            ticketObject = {destination,
                            price,
                            status,};
            output.push(ticketObject);
        });
        let sortedOutput = sortSolution(output, criteria);

        return sortedOutput;

        //console.log(outputString.replace('}, ]', '} ]'))

        function sortSolution(output, criteria){
            return output.sort((curr, next) => {
                if(criteria == 'price') {
                    return curr[criteria] - (next[criteria])
                } else{
                    return curr[criteria].localeCompare(next[criteria])
                };
            });
        }
    }

solve(['Philadelphia|94.20|available',
'New York City|95.99|available',
'New York City|95.99|sold',
'Boston|126.20|departed'],
'price'
);
solve(['Philadelphia|94.20|available',
'New York City|95.99|available',
'New York City|95.99|sold',
'Boston|126.20|departed'],
'status'
);

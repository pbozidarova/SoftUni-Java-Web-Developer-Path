class Movie {
    constructor ( movieName, ticketPrice ){
        this.movieName = movieName;
        this.ticketPrice = ticketPrice;
        this.screenings = [];
        this.currentProfit = 0;

        // Hint: Here you can add more properties to help you finish the task.  
    }
    screeningExists(date, hall){
        return this.screenings.find(scr => scr.date === date && scr.hall === hall);
    }

    newScreening(date, hall, description) {
        if(this.screeningExists(date, hall)) {
            throw new Error(`Sorry, ${hall} hall is not available on ${date}`);
        }
        
        this.screenings.push({date, hall, description})
        //console.log(this.screeningExists(date, hall));
        return `New screening of ${this.movieName} is added.`;

    }

    endScreening(date, hall, soldTickets) {
        let currentScreening = this.screeningExists(date, hall);
        if(!currentScreening){
            throw new Error(`Sorry, there is no such screening for ${this.movieName} movie.`);
        }

        this.currentProfit += this.ticketPrice * soldTickets;
    
        let screeningIndex = this.screenings.indexOf(currentScreening);
        let output = `${this.movieName} movie screening on ${currentScreening.date} in ${currentScreening.hall} hall has ended. Screening profit: ${this.ticketPrice * soldTickets}`;
        
        this.screenings.splice(screeningIndex, 1);
        return output;
    }


    toString () {
        let output = `${this.movieName} full information:`;
        output += `\nTotal profit: ${this.currentProfit}$`;
        output += `\nSold Tickets: ${this.currentProfit /this.ticketPrice }`;
        output += "\nRemaining film screenings:";
        if(this.screenings.length > 0) {

            this.screenings
            .sort((a, b) => a.hall.localeCompare(b.hall))
            .forEach(screaning => output += `\n${screaning.hall} - ${screaning.date} - ${screaning.description}`)

        } else {
            output += "No more screenings!";
        }
        
        return output.trim();
    }

}

let m = new Movie('Wonder Woman 1984', '10.00');
console.log(m.newScreening('October 2, 2020', 'IMAX 3D', `3D`));
console.log(m.newScreening('October 3, 2020', 'Main', `regular`));
console.log(m.newScreening('October 4, 2020', 'IMAX 3D', `3D`));
console.log(m.endScreening('October 2, 2020', 'IMAX 3D', 150));
console.log(m.endScreening('October 3, 2020', 'Main', 78));
console.log(m.toString());

m.newScreening('October 4, 2020', '235', `regular`);
m.newScreening('October 5, 2020', 'Main', `regular`);
m.newScreening('October 3, 2020', '235', `regular`);
m.newScreening('October 4, 2020', 'Main', `regular`);
console.log(m.toString());

// New screening of Wonder Woman 1984 is added.
// New screening of Wonder Woman 1984 is added.
// New screening of Wonder Woman 1984 is added.
// Wonder Woman 1984 movie screening on October 2, 2020 in IMAX 3D hall has ended. Screening profit: 1500
// Wonder Woman 1984 movie screening on October 3, 2020 in Main hall has ended. Screening profit: 780
// Wonder Woman 1984 full information:
// Total profit: 2280$
// Sold Tickets: 228
// Remaining film screenings:
// IMAX 3D - October 4, 2020 - 3D
 
// Wonder Woman 1984 full information:
// Total profit: 2280$
// Sold Tickets: 228
// Remaining film screenings:
// 235 - October 4, 2020 - regular
// 235 - October 3, 2020 - regular
// IMAX 3D - October 4, 2020 - 3D
// Main - October 5, 2020 - regular
// Main - October 4, 2020 - regular

function solveClasses () {
    class Pet {
        comments = [];

        constructor(owner, name) {
            this.owner = owner;
            this.name = name;
        }

        addComment(comment) {
            if(this.comments.includes(comment)) {
                throw new Error('This comment is already added!')
            }
            this.comments.push(comment);

            return 'Comment is added.';
        }

        feed() {
            return `${this.name} is fed`
        }

        toString() {
            let result = `Here is ${this.owner}'s pet ${this.name}.`
            if(this.comments.length > 0){
                result += `\n`;
                result += `Special requirements: ${this.comments.join(', ')}`;
            }
            return result;   
        }
    }

    class Cat extends Pet {
        constructor(owner, name, insideHabits, scratching){
            super(owner, name);
            this.insideHabits = insideHabits;
            this.scratching = scratching;
        }

        feed() {
            return super.feed() + ", happy and purring.";
        }

        toString() {
            let result = super.toString();
            
            result += '\n';
            result += 'Main information:';
            result += '\n';
            result += `${ this.name } is a cat with ${ this.insideHabits }`;
            
            if(this.scratching){
                result += ', but beware of scratches.';
            }

            return result;

        }

    }

    class Dog extends Pet {
        constructor(owner, name, runningNeeds, trainability) {
            super(owner, name);

            this.runningNeeds = runningNeeds;
            this.trainability = trainability;
        }

        feed() {
            return super.feed() + ", happy and wagging tail."
        }

        toString() {
            let result = super.toString();
            result += '\n'
            result += "Main information:"
            result += '\n'
            result += `${ this.name } is a dog with need of ${ this.runningNeeds }km running every day and ${ this.trainability } trainability.`;
            
            return result;
        }
    }

    return {
        Pet,
        Cat, 
        Dog
    }

}

let classes = solveClasses();
// let pet = new classes.Pet('Ann', 'Merry');
// console.log(pet.addComment('likes bananas'));
// console.log(pet.addComment('likes sweets'));
// console.log(pet.feed());
// console.log(pet.toString());

// let cat = new classes.Cat('Jim', 'Sherry', 'very good habits', true);
// console.log(cat.addComment('likes to be brushed'));
// console.log(cat.addComment('sleeps a lot'));
// console.log(cat.feed());
// console.log(cat.toString());

let dog = new classes.Dog('Susan', 'Max', 5, 'good');        
console.log(dog.addComment('likes to be brushed'));
console.log(dog.addComment('sleeps a lot'));
console.log(dog.feed());
console.log(dog.toString());

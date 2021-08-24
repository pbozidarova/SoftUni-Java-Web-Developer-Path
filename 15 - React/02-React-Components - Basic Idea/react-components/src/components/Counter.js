import { Component } from 'react';

class Counter extends Component{

    constructor(props){
        super(props)

        this.state = {
            count: 11,
            collectionName: 'My Books',
        };
    }   

    decrementCounter(){
        // this.setState({count: this.state.count - 1})
        this.setState(prevState => ({count: prevState.count - 1}));
    }

    incrementCounter(){
        this.setState(prevState => ({count: prevState.count + 1}));
    }

    resetCounter(e){
        this.setState({count: 0});
    }

    render(){

        return(
            <div className="counter">
                <h3>{this.state.collectionName }</h3>

                <button onClick={ (e) => this.decrementCounter() }>-</button>
                <span>{ this.state.count }</span>
                <button onClick={(e) => this.setState({count: this.state.count + 1})}>+</button>
                <button onClick={this.incrementCounter.bind(this)}>+</button>
                <button onClick={this.resetCounter.bind(this)}>Reset</button>
            </div>
            
        )
    }

}

export default Counter;
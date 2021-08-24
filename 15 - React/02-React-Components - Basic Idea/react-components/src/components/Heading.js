function Heading(props){

    return (
        <header>
            <h1>Hellow world</h1>
            <h2>{props.children}</h2>
        </header>
    )

};

export default Heading;
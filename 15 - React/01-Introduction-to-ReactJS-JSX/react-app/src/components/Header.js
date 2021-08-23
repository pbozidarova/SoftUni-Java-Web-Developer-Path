

function Header(props){
    let headingMessage = 'Hello React World!';

    return (
        <header className="App-header">
	    	<h1>{ props.children}</h1>
	    	<h2>{ headingMessage + '...'}</h2>
		    <p>Hello on this line too</p>
    	</header>
    
    )
}

export default Header;
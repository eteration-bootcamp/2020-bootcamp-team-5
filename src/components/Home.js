import React, {Fragment} from 'react';
import { useHistory } from "react-router-dom";
import {Jumbotron, Button} from 'react-bootstrap';
import Navigation from './Navigation';

const Home = () => {
    const history = useHistory();

    const routeChange = () =>{ 
    let path = '/signup'; 
    history.push(path);
    }

    return (
        <Fragment>
            <Navigation/>
            <Jumbotron>
                <h1>Welcome to Noteration!</h1>
                <p>
                Organize your projects, events and to-do's. Get things done with Noteration.
                </p>
                <p>
                <Button variant="primary" onClick={routeChange}>SIGN UP FOR FREE</Button>
                </p>
            </Jumbotron>

            
        </Fragment>
    )
};

export default Home;

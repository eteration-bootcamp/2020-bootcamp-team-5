import React, {Fragment} from 'react';
import { useHistory } from "react-router-dom";
import {Jumbotron, Button} from 'react-bootstrap';
import Navigation from './Navigation';
import Note from './Note';

const Home = () => {

    return (
        <Fragment>
            <Navigation/>
            <Jumbotron>
                <h1>This is your profile!</h1>
                <p>
                <Button variant="primary">Add Note</Button>
                </p>
            </Jumbotron>

            <Note/>
        </Fragment>
    )
};

export default Home;

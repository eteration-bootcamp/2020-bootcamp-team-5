import React from 'react';
import '../styles/Main.css';
import {Container, Row, Col, Button} from 'react-bootstrap';
import Navigation from '../components/Navigation';
import Note from '../components/Note';
import { useHistory } from "react-router-dom";

function NotesPage() {
    const history = useHistory();

    const routeChange = () =>{ 
      let path = '/notes/add'; 
      history.push(path);
    }

    return (
        <Container fluid>
            <Row>
                <Col className="reset-padding">
                    <Navigation/>
                </Col>
            </Row>
            
             
            <Row className="note-container justify-content-center">
                <Col xs={12} sm={12} md={12} lg={12} xl={12} className="ver-hor-center text-center">
                    <h1 class="note-container-title">My Notes</h1>
                </Col>

                <Col xs={12} sm={12} md={12} lg={12} xl={12} className="ver-hor-center add-note-button">
                    <Button variant="warning" onClick={routeChange}>Click here to add new note</Button>
                </Col>

                <Note/>
                <Note/>
                <Note/>
                <Note/>
                <Note/>
                <Note/>
                <Note/>
                <Note/>
                <Note/>
       
            </Row>
        </Container>
    );

}

export default NotesPage;
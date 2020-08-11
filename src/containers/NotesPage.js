import React from 'react';
import {Container, Row, Col, Button} from 'react-bootstrap';
import Navigation from '../components/Navigation';
import Note from '../components/Note';
import AddNoteModal from './AddNewNotePage';

function NotesPage() {
    const [modalShow, setModalShow] = React.useState(false);

    return (
        <Container fluid>
            <Row>
                <Col className="reset-padding">
                    <Navigation/>
                </Col>
            </Row>
            
             
            <Row className="note-container justify-content-center">
                <Col xs={12} sm={12} md={12} lg={12} xl={12} className="ver-hor-center text-center">
                    <h1 className="note-container-title">My Notes</h1>
                </Col>

                <Col xs={12} sm={12} md={12} lg={12} xl={12} className="ver-hor-center add-note-button">
                    <Button variant="warning" onClick={() => setModalShow(true)}>Click here to add new note</Button>
                </Col>

                <AddNoteModal
                    show={modalShow}
                    onHide={() => setModalShow(false)}
                />

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
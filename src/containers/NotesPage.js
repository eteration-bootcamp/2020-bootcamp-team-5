import React, { useEffect }  from 'react';
import {Container, Row, Col, Button} from 'react-bootstrap';
import Navigation from '../components/Navigation';
import Note from '../components/Note';
import AddNewNote from '../components/AddNewNote';
import {useDispatch, useSelector} from 'react-redux';
import {setAllNotes} from '../actions';
import {ALL_NOTES_API} from '../config/api.js';
import axios from 'axios';

function NotesPage() {
    const [modalShow, setModalShow] = React.useState(false);
    const allNotes = useSelector(state => state.allNotes);
    const dispatch = useDispatch();

    useEffect(() => {
        axios.get(ALL_NOTES_API, { 'headers': { 'auth': '1234' } })
            .then(res => {
                dispatch(setAllNotes(res.data));
            })
            .catch(error => {
                console.error(error.response);
            });
    },[]);

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

                <AddNewNote
                    show={modalShow}
                    onHide={() => setModalShow(false)}
                />

                {
                    allNotes.map((item, index) => {
                       return <Note key={index} id={item.id} title={item.title} content={item.content} />
                    })
                }
  
            </Row>
        </Container>
    );

}

export default NotesPage;

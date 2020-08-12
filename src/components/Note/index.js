import React, {useState} from 'react';
import '../../styles/Main.css';
import {Col, Card, Button} from 'react-bootstrap';
import {PencilSquare, ZoomIn, Trash, Share} from 'react-bootstrap-icons';
import EditNote from '../EditNote';
import DeleteNote from '../DeleteNote';
import ShareNote from '../ShareNote';
import ViewNote from '../ViewNote';
import axios from 'axios';
import {useSelector, useDispatch} from 'react-redux';
import {setCurrentViewNote, setDeletingStatusDeleted, setDeletingAlertBoxClosed, setDeletingAlertBoxOpen} from '../../actions';

function Note(props) {
    const [modalShow, setModalShow] = useState(false);
    const [shareShow, setShareShow] = useState(false);
    const [viewShow, setViewShow] = useState(false);
    
    const dispatch = useDispatch();
    const deletingAlertBox = useSelector(state => state.deletingAlertBox);

    function viewButtonOnClick() {
        viewNote();
        setViewShow(true); 
    }

    function editButtonOnClick() {
        viewNote();
        setModalShow(true);
    }

    function deleteButtonOnClick() {
        dispatch(setDeletingAlertBoxOpen());
        deleteNote();
    }

    /* Localhost will be changed as server ip and headers will be dynamic. */
    function viewNote() {

        axios.get(`http://localhost/notes/${props.id}`, { 'headers': { 'auth': '1234' } })
            .then(res => {
                dispatch(setCurrentViewNote(res.data));
            })
            .catch(error => {
                console.error(error.response);
            });
    }

    /* Localhost will be changed as server ip and headers will be dynamic. */
    function deleteNote() {

        axios.delete(`http://localhost/notes/delete/${props.id}`, { 'headers': { 'auth': '1234' } })
            .then(res => {
                // SUCCESS
                dispatch(setDeletingStatusDeleted());
            })
            .catch(error => {
                console.error(error.response);
            });
    }

    return (
        <Col xs={12} sm={6} md={4} lg={4} xl={4} className="note-item-col ver-hor-center">
            <Card>
                <Card.Body>
                    <Card.Title>{props.title}</Card.Title>
                    <Card.Text>
                        {props.content}
                    </Card.Text>
                    <Button variant="primary" onClick={viewButtonOnClick}><ZoomIn/></Button> {' '}
                    <ViewNote
                        show={viewShow}
                        onHide={() => setViewShow(false)}
                    />
                    <Button variant="warning" onClick={editButtonOnClick}><PencilSquare/></Button> {' '}
                    <EditNote
                        show={modalShow}
                        onHide={() => setModalShow(false)}
                    />
                    <Button variant="danger" onClick={deleteButtonOnClick}><Trash/></Button> {' '}
                    <DeleteNote
                        show={deletingAlertBox}
                    />
                    <Button variant="info" onClick={() => setShareShow(true)}><Share/></Button>
                    <ShareNote
                        show={shareShow}
                        title={props.title}
                        onHide={() => setShareShow(false)}
                    />
                </Card.Body>
            </Card>
        </Col>
    );

}

export default Note;
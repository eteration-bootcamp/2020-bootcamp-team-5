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
import {setCurrentViewNote, setDeletingStatusDeleted, setDeletingAlertBoxOpen, setDeletingStatusNoAuthory, setEditNoteBoxOpen} from '../../actions';
import {READ_NOTE_API, DELETE_NOTE_API} from '../../config/api';

function Note(props) {
    const [shareShow, setShareShow] = useState(false);
    const [viewShow, setViewShow] = useState(false);
    
    const dispatch = useDispatch();
    const deletingAlertBox = useSelector(state => state.deletingAlertBox);
    const editNoteBox = useSelector(state => state.editNoteBox);

    function viewButtonOnClick() {
        viewNote();
        setViewShow(true); 
    }

    function editButtonOnClick() {
        viewNote();
        dispatch(setEditNoteBoxOpen());
    }

    function deleteButtonOnClick() {
        dispatch(setDeletingAlertBoxOpen());
        deleteNote();
    }

    function shareButtonOnClick() {
        viewNote();
        setShareShow(true);
    }


    function viewNote() {
        axios.get(`${READ_NOTE_API}${props.id}`, { 'headers': { 'auth': localStorage.getItem('auth') } })
            .then(res => {
                dispatch(setCurrentViewNote(res.data));
            })
            .catch(error => {});
    }

    function deleteNote() {
        axios.delete(`${DELETE_NOTE_API}${props.id}`, { 'headers': { 'auth': localStorage.getItem('auth') } })
            .then(res => {
                dispatch(setDeletingStatusDeleted());
            })
            .catch(error => {
                dispatch(setDeletingStatusNoAuthory());
            });
    }

    function preview(currentNote) {
        if(currentNote) {
            const len = currentNote.length;
            return len < 40 ? (currentNote.substring(0, len) + "") : (currentNote.substring(0, 40) + "...");
        }
    }

    return (
        <Col xs={12} sm={6} md={4} lg={3} xl={3} className="note-item-col ver-hor-center">
            <Card>
                <Card.Body>
                    <Card.Title>{props.title}</Card.Title>
                    <Card.Text>
                        {preview(props.content)}
                    </Card.Text>
                    <div className="text-center">
                        <Button variant="primary" onClick={viewButtonOnClick}><ZoomIn/></Button> {' '}
                        <ViewNote
                            show={viewShow}
                            onHide={() => setViewShow(false)}
                        />
                        <Button variant="warning" onClick={editButtonOnClick}><PencilSquare/></Button> {' '}
                        <EditNote
                            show={editNoteBox}
                        />
                        <Button variant="danger" onClick={deleteButtonOnClick}><Trash/></Button> {' '}
                        <DeleteNote
                            show={deletingAlertBox}
                        />
                        <Button variant="info" onClick={shareButtonOnClick}><Share/></Button>
                        <ShareNote
                            show={shareShow}
                            title={props.title}
                            onHide={() => setShareShow(false)}
                        />
                    </div>
                </Card.Body>
            </Card>
        </Col>
    );

}

export default Note;

import React from 'react';
import {Toast} from 'react-bootstrap';
import '../../styles/Main.css';
import {useSelector, useDispatch} from 'react-redux'
import {closeToastBox} from '../../actions';
import {BellFill} from 'react-bootstrap-icons';

function CustomToast() {
    const showToast = useSelector(state => state.showToast);
    const toastTitle = useSelector(state => state.toastTitle);
    const toastContent = useSelector(state => state.toastContent);
    const dispatch = useDispatch();

    return(
        <>
            <Toast show={showToast} onClose={() => dispatch(closeToastBox())}>
                <Toast.Header>
                    <BellFill className="mr-2"/>
                    <strong className="mr-auto">{toastTitle}</strong>
                </Toast.Header>
                <Toast.Body>{toastContent}</Toast.Body>
            </Toast>
        </>
    )
}

export default CustomToast;

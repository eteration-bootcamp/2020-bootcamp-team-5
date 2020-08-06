import React, {Fragment} from 'react';
import { useHistory } from "react-router-dom";
import {Button} from 'react-bootstrap';
import Navigation from './Navigation';
import Note from './Note';
import SideMenu, {Item} from 'react-sidemenu';

const Profile = () => {

    return (
        <Fragment>
            <Navigation/>

            <Note/>
        </Fragment>
    )
};

export default Profile;

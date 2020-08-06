import React, {Component, Fragment} from 'react';
import { useHistory } from "react-router-dom";
import SideMenu, {Item} from 'react-sidemenu';

class Note extends Component {
    constructor(props) {
        super(props);

        this.state = {
          notes: []
        };

        this.addNote = this.addNote.bind(this);
        this.deleteNote = this.deleteNote.bind(this);
      }
    
    addNote(event) {
        event.preventDefault();

        var noteArr = this.state.notes;
        var newNote = this.refs.newNote.value;
        noteArr.push(newNote);

        this.setState({ notes: noteArr });
        this.refs.newNote.value = "";
    }
    
    deleteNote(name, i) {
        var notes = this.state.notes.slice();
        
        notes.splice(i, 1);
        
        this.setState({
            notes
        });
    }
    
    render() {
        return (
            <Fragment>
                <form onSubmit={this.addNote}>
                    <input type="text" placeholder="Enter New Note" ref="newNote" />
                    <button type="submit">Add</button>
                </form>
                    
                {this.state.notes.map((note, i) => {
                    return (
                        <SideMenu>
                            <Item divider={true} label="My Notes" value="segment1"/>
                                
                            <Item label={note} icon="fa-search">
                                <Item label="Item 1.1" value="item1.1" icon="fa-snapchat">
                                </Item>
                            </Item>
                                
                        </SideMenu>
                    );
                })}
                
            </Fragment>
        );
    }
};
  
export default Note;
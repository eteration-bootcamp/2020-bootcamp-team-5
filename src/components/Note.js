import React, {Component} from 'react';
import { useHistory } from "react-router-dom";
import NoteGrid from './NoteGrid';

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
            <div>
                <form onSubmit={this.addNote}>
                    <input type="text" placeholder="Enter New Note" ref="newNote" />
                    <button type="submit">Add</button>
                </form>
                <NoteGrid entries={this.state.notes} removeNote={this.deleteNote} />
            </div>
        );
    }
};
  
export default Note;
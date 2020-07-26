import React, {Component} from 'react';
import { useHistory } from "react-router-dom";


class NoteGrid extends Component {
    constructor(props) {
      super(props);
    }
  
    removeItem(item, i) {
      this.props.removeNote(item, i);
    }
  
    render() {
      return (
        <div>
          <ul>
            {this.props.entries.map((note, i) => {
              return (
                <li>
                  {note}
                  {" "}
                  <button
                    onClick={() => {
                      this.removeItem(note, i);
                    }}
                    key={i}
                  >
                    {" "}Delete
                    {" "}
                  </button>
                </li>
              );
            })}
          </ul>
        </div>
      );
    }
}

  export default NoteGrid;
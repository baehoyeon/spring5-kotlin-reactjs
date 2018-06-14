import React, {PropTypes} from 'react';
import {connect} from 'react-redux';
import { Table } from 'react-bootstrap';
import {fetchList} from '../../actions/contact';

class Contact extends React.Component {
  componentDidMount() {
   this.props.fetchList();
  }

  renderRows = (list) => list.map((data, index) => (
    <tr key={`contact-row-${index}`}>
      <td style={{ textAlign: 'center' }}>{data.id}</td>
      <td style={{ textAlign: 'center' }}>{data.name}</td>
      <td style={{ textAlign: 'center' }}>{data.phoneNumber}</td>
    </tr>
  ));

  render() {
    return (
      <div>
        <Table>
          <thead>
          <tr>
            <th style={{ textAlign: 'center' }}>ID</th>
            <th style={{ textAlign: 'center' }}>이름</th>
            <th style={{ textAlign: 'center' }}>연락처</th>
          </tr>
          </thead>
          <tbody>
          {this.renderRows(this.props.data)}
          </tbody>
        </Table>
      </div>
    );
  }
}

Contact.propTypes = {
  data: PropTypes.array,
  fetchList: PropTypes.func
};

const stateToProps = state => ({
  data: state.contact.get('data')
});

const actionToProps = dispatch => ({
  fetchList: () => fetchList(dispatch)
});

export default connect(stateToProps, actionToProps)(Contact);

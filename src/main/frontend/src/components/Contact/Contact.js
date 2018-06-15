import React, { PropTypes } from 'react';
import { connect } from 'react-redux';
import { Table, FormControl, Button } from 'react-bootstrap';
import { fetchList, handleFormValue, addUser } from '../../actions/contact';

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
        <FormControl
          type="text"
          name="name"
          placeholder="이름"
          onChange={(e) => this.props.handleFormValue('name', e.target.value)}
          value={this.props.form.get('name')}
        />
        <FormControl
          type="text"
          name="phone"
          placeholder="전화번호"
          onChange={(e) => this.props.handleFormValue('phone', e.target.value)}
          value={this.props.form.get('phone')}
        />
        <Button
          onClick={() => this.props.addUser({
            name: this.props.form.get('name'),
            phone: this.props.form.get('phone')
          })}
        >
          저장
        </Button>
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
  form: PropTypes.shape({
    name: PropTypes.string,
    phone: PropTypes.string
  }),
  fetchList: PropTypes.func,
  handleFormValue: PropTypes.func,
  addUser: PropTypes.func
};

const stateToProps = state => ({
  data: state.contact.get('data'),
  form: state.contact.get('form')
});

const actionToProps = dispatch => ({
  fetchList: () => fetchList(dispatch),
  handleFormValue: (key, value) => handleFormValue(dispatch, key, value),
  addUser: (form) => addUser(dispatch, form)
});

export default connect(stateToProps, actionToProps)(Contact);

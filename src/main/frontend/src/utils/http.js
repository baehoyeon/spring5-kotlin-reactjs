import axios from 'axios';

const HttpClient = axios.create({
  baseURL: '/api/',
  headers: {
    'Content-Type': 'application/json',
    'X-Requested-With': 'XMLHttpRequest'
  }
});

export default HttpClient;

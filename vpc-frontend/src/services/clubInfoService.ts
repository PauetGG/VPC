import axios from 'axios';

export const getClubInfo = async () => {
    const response = await axios.get('http://localhost:8080/api/club-info');
    return response.data;
};
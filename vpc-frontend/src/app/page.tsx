'use client';

import { useEffect, useState } from 'react';
import { getClubInfo } from '@/services/clubInfoService';
import { ClubInfo } from '@/types/ClubInfo';

export default function Home() {
   const [clubInfo, setClubInfo] = useState<ClubInfo[]>([]);

    useEffect(() => {
        getClubInfo().then(data => setClubInfo(data)).catch(err => console.error(err));
    }, []);

    return (
        <main>
            <h1>Club Info</h1>
            {clubInfo.length === 0 ? (
                <p>Cargando datos...</p>
            ) : (
                <ul>
                    {clubInfo.map((item) => (
                        <li key={item.id}>
                            <strong>{item.titulo}</strong>: {item.contenido}
                        </li>
                    ))}
                </ul>
            )}
        </main>
    );
}

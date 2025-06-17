import { Routes, Route, Outlet } from 'react-router-dom';
import Header from './components/Header';
import Footer from './components/Footer';
import Home from './pages/Home';
import Patrocinadors from './pages/Patrocinadors';
import './App.css';
import Estadi from './pages/Estadi';
import Junta from './pages/Junta';
import Historia from './pages/Historia';
import Palmares from './pages/Palmares';
import Botiga from './pages/Botiga';
import PrimerEquipPlantilla from './pages/PrimerEquipPlantilla';
import EquipFemeniPlantilla from './pages/EquipFemeniPlantilla';
import SegonEquipPlantilla from './pages/SegonEquipPlantilla';
import Sub18Plantilla from './pages/Sub18Plantilla';
import Sub16Plantilla from './pages/Sub16Plantilla';
import Sub14Plantilla from './pages/Sub14Plantilla';
// importa otras páginas aquí si las tienes

export default function App() {
  return (
    <div className="min-h-screen flex flex-col">
      <Header />
      <main className="flex-grow">
        <Routes>
          <Route path="/" element={<Outlet />}>
            <Route index element={<Home />} />
            <Route path="patrocinadors" element={<Patrocinadors />} />
            <Route path="/estadi" element={<Estadi />} />
            <Route path="/junta" element={<Junta />} />
            <Route path="/historia" element={<Historia />} />
            <Route path="/palmares" element={<Palmares />} />
            <Route path="/botiga" element={<Botiga />} />
            <Route path="/primer-equip-plantilla" element={<PrimerEquipPlantilla />} />
            <Route path="/equip-femeni-plantilla" element={<EquipFemeniPlantilla />} />
            <Route path="/segon-equip-plantilla" element={<SegonEquipPlantilla />} />
            <Route path="/sub18-plantilla" element={<Sub18Plantilla />} />
            <Route path="/sub16-plantilla" element={<Sub16Plantilla />} />
            <Route path="/sub14-plantilla" element={<Sub14Plantilla />} />
            {/* más rutas aquí */}
            {/* <Route path="noticies" element={<Noticies />} /> */}
          </Route>
        </Routes>
      </main>
      <Footer />
    </div>
  );
}

import { Link } from 'react-router-dom';
import { FaInstagram, FaFacebookF, FaYoutube, FaXTwitter, FaChevronDown } from 'react-icons/fa6';

export default function Header() {
  return (
    <header className="bg-black text-white w-full z-50">
      {/* Primera línea: Logo + Redes */}
      <div className="relative flex items-center justify-center px-6 py-6 min-h-[100px] border-b border-white/10">
        {/* Logo centrado absoluto */}
        <div className="absolute left-1/2 -translate-x-1/2">
          <img src="/logos/vpc_logo.png" alt="Logo VPC" className="h-24" />
        </div>

        {/* Redes sociales a la derecha */}
        <div className="ml-auto flex space-x-4 text-xl">
          <a href="https://x.com/vpcandorra" target="_blank" rel="noopener noreferrer">
            <FaXTwitter className="hover:text-[oklch(0.87_0.17_100.69)]" />
          </a>
          <a href="https://www.instagram.com/vpcandorra/" target="_blank" rel="noopener noreferrer">
            <FaInstagram className="hover:text-[oklch(0.87_0.17_100.69)]" />
          </a>
          <a href="https://www.facebook.com/VPCANDORRA/" target="_blank" rel="noopener noreferrer">
            <FaFacebookF className="hover:text-[oklch(0.87_0.17_100.69)]" />
          </a>
          <a href="https://www.youtube.com/c/RugbiAndorra" target="_blank" rel="noopener noreferrer">
            <FaYoutube className="hover:text-[oklch(0.87_0.17_100.69)]" />
          </a>
        </div>
      </div>

      {/* Segona línia: Menú principal */}
      <div className="flex justify-center items-center space-x-8 px-6 py-4 min-h-[60px] border-t border-white/10 text-sm font-bold uppercase tracking-wide relative">
        <Link to="/equips" className="hover:text-[oklch(0.87_0.17_100.69)]">Equips</Link>

        {/* El Club amb submenú */}
       <div className="relative group inline-block text-left">
          {/* Botó principal */}
          <button className="inline-flex items-center gap-1 hover:text-[oklch(0.87_0.17_100.69)] transition">
            EL CLUB
            <FaChevronDown className="text-xs transition-transform duration-300 group-hover:rotate-180" />
          </button>

          {/* Submenú sense marge real (per mantenir hover), però amb padding intern */}
          <div
            className="absolute left-1/2 -translate-x-1/2 top-full w-48 bg-black text-white rounded shadow-lg z-50 border border-white/10
                      opacity-0 invisible group-hover:opacity-100 group-hover:visible transition duration-200
                      pointer-events-none group-hover:pointer-events-auto"
          >
            <ul className="flex flex-col divide-y divide-white/10 text-sm text-center py-2">
              <li><Link to="/historia" className="block px-4 py-2 hover:text-[oklch(0.87_0.17_100.69)]">Història</Link></li>
              <li><Link to="/junta" className="block px-4 py-2 hover:text-[oklch(0.87_0.17_100.69)]">Junta Directiva</Link></li>
              <li><Link to="/palmares" className="block px-4 py-2 hover:text-[oklch(0.87_0.17_100.69)]">Palmarès</Link></li>
              <li><Link to="/estadi" className="block px-4 py-2 hover:text-[oklch(0.87_0.17_100.69)]">Estadi</Link></li>
            </ul>
          </div>
        </div>

        <Link to="/socis" className="hover:text-[oklch(0.87_0.17_100.69)]">Socis</Link>
        <Link to="/noticies" className="hover:text-[oklch(0.87_0.17_100.69)]">Notícies</Link>
        <Link to="/patrocinadors" className="hover:text-[oklch(0.87_0.17_100.69)]">Patrocinadors</Link>
        <Link to="/botiga" className="hover:text-[oklch(0.87_0.17_100.69)]">Botiga del Club</Link>
      </div>
    </header>
  );
}

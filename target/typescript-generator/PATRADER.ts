/* tslint:disable */
/* eslint-disable */
// Generated using typescript-generator version 2.14.505 on 2019-05-08 15:33:22.

export class Almacen {
    idAlmacen: number;
    identificacion: string;
}

export class Bulto {
    id: number;
    identificacion: string;
    consecutivo: number;
    anio: number;
    tipoDesecho: TipoDesecho;
    fechaEnvase: Date;
    fechaMedicion: Date;
    dosisContacto: number;
    dosis1m: number;
    clasificacion: string;
    actividadInicial: number;
    actividadActual: number;
    actividadEspecifica: number;
    concentracion: number;
    masa: number;
    observaciones: string;
    preparoBulto: Persona;
    fechaPreparo: Date;
    revisoBulto: Persona;
    fechaReviso: Date;
    valorD: number;
    valorA_D: number;
    categoria: number;
    vidaMedia: string;
    tipoGestion: TipoGestion;
    cumpleNom035: boolean;
    campania: Campania;
    tratamiento: string;
    almacen: Almacen;
    desechos: Desecho[];
    pozos: Pozo[];
}

export class Campania {
    id: number;
    identificacion: string;
}

export class Desecho {
    id: number;
    identificacion: string;
    consecutivo: number;
    tipoDesecho: TipoDesecho;
    radionuclido: Radionuclido;
    actividadInicial: number;
    actividadFinal: number;
    actividadRotulada: number;
    densidad: number;
    dosisContacto: number;
    dosis1m: number;
    metodoMedicion: MetodoMedicion;
    numeroAutorizacionCNSNS: string;
    fechaCalibracion: Date;
    fechaEntrada: Date;
    fechaSalida: Date;
}

export class DesechoLiquido extends Desecho {
    volumen: number;
    tipoEnvase: TipoEnvase;
}

export class DesechoSolido extends Desecho {
    peso: number;
    tipoEnvase: TipoEnvase;
}

export class Empresa {
    id: number;
    nombre: string;
    telefono: string;
    calle: string;
    num_calle: string;
    codigo_postal: number;
    colonia: string;
    representante: Persona;
    fechaCreacion: Date;
}

export class Folio {
    id: number;
    identificacion: string;
    desechos: Desecho[];
    anio: number;
    empresa: Empresa;
    numeroLicencia: string;
    persEsr: Persona;
    reutilizarAutorizado: boolean;
    recepcion: Almacen;
    fechaRecepcion: Date;
    persEntrego: Persona;
    persRecibio: Persona;
    persReviso: Persona;
    fechaReviso: Date;
    tipoDesecho: TipoDesecho;
    emisor: TipoEmisor;
    listaObservaciones: string[];
}

export class FuenteSellada extends Desecho {
    peso: number;
    fechaFabricacion: Date;
    marcaContenedor: Marca;
    marcaFuente: Marca;
    numeroSerieCont: number;
    numeroSerieFuente: number;
}

export class Marca {
    id: number;
    identificacion: string;
    fechaCreacion: Date;
}

export class MetodoMedicion {
    id: number;
    identificacion: string;
}

export class Persona {
    id: number;
    nombre: string;
    apellidoPaterno: string;
    apellidoMaterno: string;
}

export class Pozo {
    id: number;
    consecutivo: number;
    desechos: Desecho[];
    radionuclido: Radionuclido;
}

export class Radionuclido {
    id: number;
    identificacion: string;
    vidaMedia: number;
    emisor: TipoEmisor;
}

export class TipoDesecho {
    id: number;
    identificacion: string;
}

export class TipoEmisor {
    id: number;
    identificacion: string;
}

export class TipoEnvase {
    id: number;
    identificacion: string;
    tipoDesecho: TipoDesecho;
    volumen: number;
    peso: number;
}

export class TipoGestion {
    id: number;
    identificacion: string;
}

export class Usuario extends Persona {
    password: string;
}

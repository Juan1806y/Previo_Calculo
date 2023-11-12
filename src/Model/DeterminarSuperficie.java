/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author forer
 */
package Model;

public class DeterminarSuperficie {
    //A x^(2)+B y^(2)+C z^(2)+D x+E y+F z+G=0

    private double A;
    private double B;
    private double C;
    private double D;
    private double E;
    private double F;
    private double G;

    public DeterminarSuperficie() {
    }

    public DeterminarSuperficie(double A, double B, double C, double D, double E, double F, double G) {
        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;
        this.E = E;
        this.F = F;
        this.G = G;
    }

    //------------------------------------------------------------------------------------------------------//
    public boolean esEsfera(double A, double B, double C, double D, double E, double F, double G) {
        if (A < 0 && B < 0 && C < 0) {
            A = A * -1;
            B = B * -1;
            C = C * -1;

            G = G * -1;
        }

        double radioParcial = Math.sqrt((Math.pow(D, 2) + Math.pow(E, 2) + Math.pow(F, 2) - 4 * A * G) / (4 * A));
        double diametro = Math.sqrt(radioParcial);
        double radio = diametro / 2;

        if (radio > 0) {
            if ((A == B && B == C) && (A != 0) && (B != 0) && (C != 0)) {
                return true;
            }
        }
        return false;
    }

    //elipsoide parece redundante pero por alguna razon si se toca algo los datos se alteran
    //si encuentran una forma de optimizar los calculos ta bien 
    public boolean esElipsoide(double A, double B, double C, double D, double E, double F, double G) {

        double constante;
        double volumen;
        double p, q, r;
        double discriminante;
        double a, b, c;

        A /= 2;
        B /= 2;
        C /= 2;
        D /= 2;
        E /= 2;
        F /= 2;
        G /= 2;

        p = -D / (2 * A);
        q = -E / (2 * B);
        r = -F / (2 * C);

        constante = G - (A * p * p + B * q * q + C * r * r);

        constante *= 2;
        A *= 2;
        B *= 2;
        C *= 2;
        D *= 2;
        E *= 2;
        F *= 2;

        a = (A) / -constante;
        b = (B) / -constante;
        c = (C) / -constante;

        a = Math.sqrt(1 / a);
        b = Math.sqrt(1 / b);
        c = Math.sqrt(1 / c);

        volumen = (4.0 * Math.PI * a * b * c) / 3.0;

        //System.out.println(volumen);
        discriminante = (A * B * C) + (2 * D * E * F) - (A * E * E) - (B * D * D) - (C * F * F);

        if ((A != B) || (B != C) || (C != A) && (discriminante > 0) && (volumen > 0)) {
            if ((A > 0) && (B > 0) && (C > 0)) {
                return true;
            } else if ((A < 0) && (B < 0) && (C < 0)) {
                return true;
            }
        }
        return false;
    }

    //Cilindro es un poco largo porque hace el calculo en cada direccion que puede tomar un cilindro cerrado
    public boolean esCilindrica(double A, double B, double C, double D, double E, double F, double G) {

        double area = 0;
        double p, q, r;
        double constante;
        double a, b, c;

        if ((A == 0) || (B == 0) || (C == 0)) {

            A /= 2;
            B /= 2;
            C /= 2;
            D /= 2;
            E /= 2;
            F /= 2;
            G /= 2;

            if ((A != 0) && (B != 0) && (C == 0)) {

                p = -D / (2 * A);
                q = -E / (2 * B);

                constante = G - (A * p * p + B * q * q);

                constante *= 2;
                A *= 2;
                B *= 2;

                a = (A) / -constante;
                b = (B) / -constante;

                a = Math.sqrt(1 / a);
                b = Math.sqrt(1 / b);

                area = (Math.PI * (a) * (b));

                //System.out.println(a + "  " + p + "  " + b + "  " + q + "  " + constante);
                //System.out.println(area);
            } else if ((A != 0) && (C != 0) && (B == 0)) {

                p = -D / (2 * A);
                r = -F / (2 * C);

                constante = G - (A * p * p + C * r * r);

                constante *= 2;
                A *= 2;
                B *= 2;
                C *= 2;

                a = (A) / -constante;
                c = (C) / -constante;

                a = Math.sqrt(1 / a);
                c = Math.sqrt(1 / c);

                area = (Math.PI * (a) * (c));

                //System.out.println(a + "  " + p + "  " + c + "  " + r + "  " + constante);
                //System.out.println(area);
            } else if ((B != 0) && (C != 0) && (A == 0)) {

                q = -E / (2 * B);
                r = -F / (2 * C);

                constante = G - (B * q * q + C * r * r);

                constante *= 2;
                A *= 2;
                B *= 2;
                C *= 2;

                b = (B) / -constante;
                c = (C) / -constante;

                b = Math.sqrt(1 / b);
                c = Math.sqrt(1 / c);

                area = (Math.PI * (b) * (c));

                //System.out.println(b + "  " + q + "  " + c + "  " + r + "  " + constante);
                //System.out.println(area);
            }

            if ((area > 0)) {
                if ((A < 0) && (B < 0) && (C == 0) && (F == 0)) {
                    return true;
                }
                if ((A < 0) && (C < 0) && (B == 0) && (E == 0)) {
                    return true;
                }
                if ((B < 0) && (C < 0) && (A == 0) && (D == 0)) {
                    return true;
                }
                if ((A > 0) && (B > 0) && (C == 0) && (F == 0)) {
                    return true;
                }
                if ((A > 0) && (C > 0) && (B == 0) && (E == 0)) {
                    return true;
                }
                if ((B > 0) && (C > 0) && (A == 0) && (D == 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean esCilindroParabolico(double A, double B, double C, double D, double E, double F, double G) {

        if ((A == 0) && (B == 0) && (C != 0) && ((D != 0) || (E != 0))) {
            return true;
        } else if ((A == 0) && (C == 0) && (B != 0) && ((D != 0) || (F != 0))) {
            return true;
        } else if ((C == 0) && (B == 0) && (A != 0) && ((F != 0) || (E != 0))) {
            return true;
        }
        return false;
    }

    public boolean esCilindroHP(double A, double B, double C, double D, double E, double F, double G) {
        if ((A == 0) || (B == 0) || (C == 0)) {

            if (G == 0) {

                if ((D * D != E * E) && (D != 0 || E != 0)) {
                    if ((A < 0) && (B > 0) && (F == 0)) {
                        return true;
                    }
                    if ((A > 0) && (B < 0) && (F == 0)) {
                        return true;
                    }
                }
                if ((D * D != F * F) && (D != 0 || F != 0)) {
                    if ((A < 0) && (C > 0) && (E == 0)) {
                        return true;
                    }
                    if ((A > 0) && (C < 0) && (E == 0)) {
                        return true;
                    }
                }
                if ((E * E != F * F) && (E != 0 || F != 0)) {
                    if ((B < 0) && (C > 0) && (D == 0)) {
                        return true;
                    }
                    if ((B > 0) && (C < 0) && (D == 0)) {
                        return true;
                    }
                }
            }

            if (G != 0) {
                if ((A < 0) && (B > 0) && (F == 0)) {
                    return true;
                }
                if ((A > 0) && (B < 0) && (F == 0)) {
                    return true;
                }
                if ((A < 0) && (C > 0) && (E == 0)) {
                    return true;
                }
                if ((A > 0) && (C < 0) && (E == 0)) {
                    return true;
                }
                if ((B < 0) && (C > 0) && (D == 0)) {
                    return true;
                }
                if ((B > 0) && (C < 0) && (D == 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean esParaboloideEliptico(double A, double B, double C, double D, double E, double F, double G) {
        if ((A == 0) || (B == 0) || (C == 0)) {

            if (A > 0 && B > 0 && F != 0) {
                return true;
            }
            if (A > 0 && C > 0 && E != 0) {
                return true;
            }
            if (B > 0 && C > 0 && D != 0) {
                return true;
            }
            if (A < 0 && B < 0 && F != 0) {
                return true;
            }
            if (A < 0 && C < 0 && E != 0) {
                return true;
            }
            if (B < 0 && C < 0 && D != 0) {
                return true;
            }
        }

        return false;
    }

    public boolean esParaboloideHiperbolico(double A, double B, double C, double D, double E, double F, double G) {
        if ((A == 0) || (B == 0) || (C == 0)) {

            if (A < 0 && B > 0 && F != 0) {
                return true;
            }
            if (A < 0 && C > 0 && E != 0) {
                return true;
            }
            if (B < 0 && C > 0 && D != 0) {
                return true;
            }
            if (A > 0 && B < 0 && F != 0) {
                return true;
            }
            if (A > 0 && C < 0 && E != 0) {
                return true;
            }
            if (B > 0 && C < 0 && D != 0) {
                return true;
            }
        }

        return false;
    }

    public boolean esConoEliptico(double A, double B, double C, double D, double E, double F, double G) {
        if (((A * B * C != 0)) && (G == 0)) {
            if (((A > 0 && B < 0 && C < 0) || (A < 0 && B > 0 && C < 0) || (A < 0 && B < 0 && C > 0)) && (D == 0 && E == 0 && F == 0)) {
                return true;
            }
            if (((A < 0 && B > 0 && C > 0) || (A > 0 && B < 0 && C > 0) || (A > 0 && B > 0 && C < 0)) && (D == 0 && E == 0 && F == 0)) {
                return true;
            }
            if (((A < 0 && B > 0) || (A > 0 && B < 0)) && (A * A == B * B) && (D * D == E * E) && F == 0) {
                return true;
            }
            if (((A < 0 && C > 0) || (A > 0 && C < 0)) && (A * A == C * C) && (D * D == F * F) && E == 0) {
                return true;
            }
            if (((C < 0 && B > 0) || (C > 0 && B < 0)) && (B * B == C * C) && (F * F == E * E) && D == 0) {
                return true;
            }

        }
        return false;

    }

    public boolean esHiperboloideDeUnaHoja(double A, double B, double C, double D, double E, double F, double G) {

        double constante;
        double p, q, r;

        A /= 2;
        B /= 2;
        C /= 2;
        D /= 2;
        E /= 2;
        F /= 2;
        G /= 2;

        p = -D / (2 * A);
        q = -E / (2 * B);
        r = -F / (2 * C);

        constante = G - (A * p * p + B * q * q + C * r * r);

        constante *= 2;

        if ((A < 0 && B > 0 && C > 0) || (A > 0 && B < 0 && C > 0) || (A > 0 && B > 0 && C < 0)) {
            if (constante < 0) {
                return true;
            }
        }
        if ((A > 0 && B < 0 && C < 0) || (A < 0 && B > 0 && C < 0) || (A < 0 && B < 0 && C > 0)) {
            if (constante > 0) {
                return true;
            }
        }
        return false;
    }

    public boolean esHiperboloideDeDosHojas(double A, double B, double C, double D, double E, double F, double G) {

        double constante;
        double p, q, r;

        A /= 2;
        B /= 2;
        C /= 2;
        D /= 2;
        E /= 2;
        F /= 2;
        G /= 2;

        p = -D / (2 * A);
        q = -E / (2 * B);
        r = -F / (2 * C);

        constante = G - (A * p * p + B * q * q + C * r * r);

        constante *= 2;

        if ((A < 0 && B > 0 && C > 0) || (A > 0 && B < 0 && C > 0) || (A > 0 && B > 0 && C < 0)) {
            if (constante > 0) {
                return true;
            }
        }
        if ((A > 0 && B < 0 && C < 0) || (A < 0 && B > 0 && C < 0) || (A < 0 && B < 0 && C > 0)) {
            if (constante < 0) {
                return true;
            }
        }
        return false;
    }

    public boolean esPlano(double A, double B, double C, double D, double E, double F, double G) {
        double constante;
        double p, q, r;

        p = -D / (2 * A);
        q = -E / (2 * B);
        r = -F / (2 * C);

        if ((A != 0 && B == 0 && C == 0) && (D != 0 && E == 0 && F == 0)) {
            constante = G - (A * p * p);
            constante = constante*10;

            constante = Math.round(constante);

            constante /= 10;

            if (constante == 0) {

                return true;
            }
        }
        if ((A == 0 && B != 0 && C == 0) && (D == 0 && E != 0 && F == 0)) {
            constante = G - (B * q * q);
            constante = constante*10;

            constante = Math.round(constante);

            constante /= 10;

            if (constante == 0) {

                return true;
            }
        }
        if ((A == 0 && B == 0 && C != 0) && (D == 0 && E == 0 && F != 0)) {
            constante = G - (C * r * r);
            constante = constante*10;

            constante = Math.round(constante);

            constante /= 10;

            if (constante == 0) {

                return true;
            }
        } 
        if((A == 0 && B == 0 && C == 0) && (D != 0 || E != 0 || F != 0)) {
            return true;
        }
        return false;
    }

    public boolean esPlanoPerpendicular(double A, double B, double C, double D, double E, double F, double G) {
        if (G == 0 && ((A == 0) || (B == 0) || (C == 0))) {
            if (((A < 0 && B > 0) || (A > 0 && B < 0)) && (A * A == B * B) && (D * D == E * E) && F == 0) {
                return true;
            }
            if (((A < 0 && C > 0) || (A > 0 && C < 0)) && (A * A == C * C) && (D * D == F * F) && E == 0) {
                return true;
            }
            if (((C < 0 && B > 0) || (C > 0 && B < 0)) && (B * B == C * C) && (F * F == E * E) && D == 0) {
                return true;
            }
            if (D == 0 && E == 0 && F == 0) {
                if ((A < 0 && B > 0) || (A > 0 && B < 0)) {
                    return true;
                }
                if ((A < 0 && C > 0) || (A > 0 && C < 0)) {
                    return true;
                }
                if ((C < 0 && B > 0) || (C > 0 && B < 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean esPlanoParalelo(double A, double B, double C, double D, double E, double F, double G) {
        double constante;
        double p, q, r;

        p = -D / (2 * A);
        q = -E / (2 * B);
        r = -F / (2 * C);

        if ((A != 0 && B == 0 && C == 0) && (D != 0 && E == 0 && F == 0)) {
            constante = (A * p * p);
            constante = constante*10;

            constante = Math.round(constante);

            constante /= 10;

            if (A > 0 && G < constante) {
                return true;
            }
            if (A < 0 && G > constante) {

                return true;
            }
        }
        if ((A == 0 && B != 0 && C == 0) && (D == 0 && E != 0 && F == 0)) {
            constante = (B * q * q);
            constante = constante*10;

            constante = Math.round(constante);

            constante /= 10;

            if (B > 0 && G < constante) {

                return true;
            }
            if (B < 0 && G > constante) {

                return true;
            }
        }
        if ((A == 0 && B == 0 && C != 0) && (D == 0 && E == 0 && F != 0)) {
            constante = (C * r * r);
            constante = constante*10;

            constante = Math.round(constante);

            constante /= 10;

            if (C > 0 && G < constante) {

                return true;
            }
            if (C < 0 && G > constante) {

                return true;
            }
        }
        return false;
    }

    //-----------------------------------------------------------------------------------------------------//
    public int verificarSuperficie(double A, double B, double C, double D, double E, double F, double G) {
        if (esEsfera(A, B, C, D, E, F, G)) {
            return 1;
        } else if (esCilindrica(A, B, C, D, E, F, G)) {
            return 2;
        } else if (esCilindroParabolico(A, B, C, D, E, F, G)) {
            return 3;
        } else if (esCilindroHP(A, B, C, D, E, F, G)) {
            return 4;
        } else if (esParaboloideEliptico(A, B, C, D, E, F, G)) {
            return 5;
        } else if (esParaboloideHiperbolico(A, B, C, D, E, F, G)) {
            return 6;
        } else if (esElipsoide(A, B, C, D, E, F, G)) {
            return 7;
        } else if (esConoEliptico(A, B, C, D, E, F, G)) {
            return 8;
        } else if (esHiperboloideDeUnaHoja(A, B, C, D, E, F, G)) {
            return 9;
        } else if (esHiperboloideDeDosHojas(A, B, C, D, E, F, G)) {
            return 10;
        } else if (esPlano(A, B, C, D, E, F, G)) {
            return 11;
        } else if (esPlanoPerpendicular(A, B, C, D, E, F, G)) {
            return 12;
        } else if (esPlanoParalelo(A, B, C, D, E, F, G)) {
            return 13;
        } else if (A == 0 && B == 0 && C == 0 && D == 0 && E == 0 && F == 0 && G == 0) {
            return 14;
        } else {
            return 0;
        }
    }
    //-----------------------------------------------------------------------------------------------------//

    /**
     * @return the A
     */
    public double getA() {
        return A;
    }

    /**
     * @param A the A to set
     */
    public void setA(double A) {
        this.A = A;
    }

    /**
     * @return the B
     */
    public double getB() {
        return B;
    }

    /**
     * @param B the B to set
     */
    public void setB(double B) {
        this.B = B;
    }

    /**
     * @return the C
     */
    public double getC() {
        return C;
    }

    /**
     * @param C the C to set
     */
    public void setC(double C) {
        this.C = C;
    }

    /**
     * @return the D
     */
    public double getD() {
        return D;
    }

    /**
     * @param D the D to set
     */
    public void setD(double D) {
        this.D = D;
    }

    /**
     * @return the E
     */
    public double getE() {
        return E;
    }

    /**
     * @param E the E to set
     */
    public void setE(double E) {
        this.E = E;
    }

    /**
     * @return the F
     */
    public double getF() {
        return F;
    }

    /**
     * @param F the F to set
     */
    public void setF(double F) {
        this.F = F;
    }

    /**
     * @return the G
     */
    public double getG() {
        return G;
    }

    /**
     * @param G the G to set
     */
    public void setG(double G) {
        this.G = G;
    }

}

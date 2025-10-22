<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" indent="yes" />

    <xsl:template match="/">
        <html>
        <head><title>Liste des Films</title></head>
        <body>
            <h1> Liste des Films</h1>
            <table border="1" cellpadding="5">
                <tr bgcolor="#CCCCCC">
                    <th>Titre</th>
                    <th>Année</th>
                    <th>Genre</th>
                    <th>Réalisateur</th>
                    <th>Acteurs</th>
                </tr>
                <xsl:for-each select="cinema/films/film">
                    <tr>
                        <td><xsl:value-of select="titre"/></td>
                        <td><xsl:value-of select="annee"/></td>
                        <td><xsl:value-of select="genre"/></td>
                        <td><xsl:value-of select="realisateur"/></td>
                        <td>
                            <xsl:for-each select="acteurs/acteur">
                                <xsl:value-of select="."/><xsl:if test="position() != last()">, </xsl:if>
                            </xsl:for-each>
                        </td>
                    </tr>
                </xsl:for-each>
            </table>
        </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
